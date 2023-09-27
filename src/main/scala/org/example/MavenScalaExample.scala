package org.example
import org.apache.spark.sql.{DataFrame, SparkSession}
object MavenScalaExample {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder()
      .appName("ScalaSparkTransformations")
      .master("local") // Set master to "local" for local mode
      .getOrCreate()
    val csvFilePath = raw"/tmp/bd_us/Demetric/sample_data.csv"
    // Read the CSV file
    val df: DataFrame = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(csvFilePath)

    // Show the original DataFrame
    df.show()
  }
}
