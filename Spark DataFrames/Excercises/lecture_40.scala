import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// Grab small dataset with some missing data
val df = spark.read.option("header","true").option("inferSchema","true").csv("ContainsNull.csv")

//removes any rows with any null values on any columns
//df.na.drop().show()

//drops rows with less than 2 non-null values
//df.na.drop(2).show()

//fills all numerical columns with 100
//df.na.fill(100).show()

//fills name column with "New Name"
//df.na.fill("New Name", Array("Name")).show()

val df2 = df.na.fill(400.5, Array("sales"))
df2.na.fill("Missing Name", Array("Name")).show()
