import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema", "true").csv("CitiGroup2006_2008")

val df2 = df.withColumn("HighPlusLow", df("High")+df("Low"))

df2.select(df2("HighPlusLow").as("HPL")).show()
