// DATAFRAME PROJECT
// Use the Netflix_2011_2016.csv file to Answer and complete
// the commented tasks below!

// Start a simple Spark Session

// Load the Netflix Stock CSV File, have Spark infer the data types.
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.stat.Correlation
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")

// What are the column names?
// What does the Schema look like?
df.printSchema()

// Print out the first 5 columns.
df.head(5)

// Use describe() to learn about the DataFrame.
df.describe().show();

// Create a new dataframe with a column called HV Ratio that
// is the ratio of the High Price versus volume of stock traded
// for a day.
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))

// What day had the Peak High in Price?
df.select($"Date").orderBy($"High".desc).head(1)

// What is the mean of the Close column?
df.select(mean("Close")).show()

// What is the max and min of the Volume column?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

// For Scala/Spark $ Syntax

// How many days was the Close lower than $ 600?
df.filter($"Close"<600).count()

// What percentage of the time was the High greater than $500 ?
df.filter($"High">500).count() / df.count()

// What is the Pearson correlation between High and Volume?
df.stat.corr("High", "Volume", "pearson")

// What is the max High per year?
df.withColumn("Year",year(df("Date"))).groupBy("Year").max().select($"Year",$"max(High)").show()

// What is the average Close for each Calender Month?
df.withColumn("Month",month(df("Date"))).withColumn("Year",year(df("Date"))).groupBy("Month", "Year").avg().select($"Month", $"Year", $"avg(Close)").show()
