package com.epam.services

import java.util

import com.epam.repo.WordsRepo
import org.apache.spark.sql.SparkSession
import org.junit.jupiter.api.{Assertions, Test}
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author Evgeny Borisov
 */
class MusicServiceTest {

  @Test
  def testTopX(): Unit = {

    val sparkSession = SparkSession.builder().appName("m").master("local[*]").getOrCreate()


    val repo = Mockito.mock(classOf[WordsRepo])

    val userProps: UserProps = new UserProps(new util.ArrayList[String]())
    userProps.garbage.add("i")

    Mockito.when(repo.allLines(""))
      .thenReturn(sparkSession.sparkContext.parallelize(
        Seq("Java", "java", "i", "i", "i", "i", "i", "i", "JAVA", "scala", "scala", "C#", "JaVa")))


    val musicService = new MusicServiceImpl(repo, sparkSession.sparkContext.broadcast(userProps))


    val strings: List[String] = musicService.topX("", 2)

    Assertions.assertEquals("java",strings(0))
    Assertions.assertEquals("scala",strings(1))






  }
}





