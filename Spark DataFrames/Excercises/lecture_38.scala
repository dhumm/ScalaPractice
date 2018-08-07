import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("CitiGroup2006_2008")
df.printSchema()

///////
//////
import spark.implicits._

//df.filter($"Close"<480 && $"High"<480).show()

val CH_low = df.filter("Close < 480 AND High<480").count

df.select(corr("High", "Low")).show()
