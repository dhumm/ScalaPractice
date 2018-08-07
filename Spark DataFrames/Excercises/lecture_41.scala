// Dates and TimeStamps

// Start a simple Spark Session
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Create a DataFrame from Spark Session read csv
// Technically known as class Dataset
val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008")

//Returns month
//df.select(year(df("Date"))).show()

//create a new dataframe with a year column peeled off the existing date column
val df2 = df.withColumn("Year", year(df("Date")))

//create a new datafrom aggregated by the minimum closing price each year
val dfmins = df2.groupBy("Year").min()

//Need to change column name here because of the generated spark column
dfmins.show()
