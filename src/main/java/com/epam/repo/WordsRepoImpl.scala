package com.epam.repo

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author Evgeny Borisov
 */
@Component
class WordsRepoImpl(sc:SparkContext) extends WordsRepo with Serializable {

  override def allLines(musicianName: String): RDD[String] = {
    sc.textFile(s"data/songs/$musicianName")

  }
}
