package com.epam.services

import com.epam.repo.WordsRepo
import com.epam.utils.WordsUtil
import org.springframework.stereotype.Component

import scala.collection.JavaConverters.asScalaBufferConverter

/**
 * @author Evgeny Borisov
 */
@Component
class MusicServiceImpl(@transient wordsRepo: WordsRepo,val userProps: UserProps) extends MusicService with Serializable {


  override def topXWithRate(musicianName: String, x: Int): Map[String, Int] = {
    wordsRepo.allLines(musicianName)
      .map(_.toLowerCase())
      .flatMap(line => WordsUtil.getWords(line).asScala)
      .filter(!this.userProps.garbage.contains(_))
      .map((_, 1))
      .reduceByKey(_ + _)
      .map(_.swap)
      .sortByKey(ascending = false)
      .map(_.swap)
      .take(x)
      .toMap


  }

  override def topX(musicianName: String, x: Int): List[String] = {
    topXWithRate(musicianName, x).map(_._1).toList
  }
}
