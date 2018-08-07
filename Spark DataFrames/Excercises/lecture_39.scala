import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()


val df = spark.read.option("header", "true").option("inferSchema", "true").csv("Sales.csv")


df.groupBy("Company").mean().show()

df.orderBy($"Sales".desc).show()
//df.groupBy("Company").max().show()
//df.groupBy("Company").min().show()
//df.groupBy("Company").sum().show()
