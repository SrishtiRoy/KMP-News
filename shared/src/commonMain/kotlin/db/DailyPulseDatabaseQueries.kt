package db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.SqlDriver
import petros.efthymiou.dailypulse.db.Article
import petros.efthymiou.dailypulse.db.Source
import kotlin.Any
import kotlin.String

public class DailyPulseDatabaseQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAllArticles(mapper: (
    title: String,
    desc: String?,
    date: String,
    imageUrl: String?,
  ) -> T): Query<T> = Query(345_586_540, arrayOf("Article"), driver, "DailyPulseDatabase.sq",
      "selectAllArticles", """
  |SELECT Article.*
  |FROM Article
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1),
      cursor.getString(2)!!,
      cursor.getString(3)
    )
  }

  public fun selectAllArticles(): Query<Article> = selectAllArticles { title, desc, date,
                                                                                                                            imageUrl ->
    Article(
      title,
      desc,
      date,
      imageUrl
    )
  }

  public fun <T : Any> selectAllSources(mapper: (
    id: String,
    name: String,
    desc: String,
    language: String,
    country: String,
  ) -> T): Query<T> = Query(661_311_657, arrayOf("Source"), driver, "DailyPulseDatabase.sq",
      "selectAllSources", """
  |SELECT Source.*
  |FROM Source
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!
    )
  }

  public fun selectAllSources(): Query<Source> = selectAllSources { id, name, desc, language,
                                                                    country ->
    Source(
      id,
      name,
      desc,
      language,
      country
    )
  }

  public fun insertArticle(
    title: String,
    desc: String?,
    date: String,
    imageUrl: String?,
  ) {
    driver.execute(-1_636_572_153, """
        |INSERT INTO Article(title, desc, date, imageUrl)
        |VALUES(?, ?, ?, ?)
        """.trimMargin(), 4) {
          bindString(0, title)
          bindString(1, desc)
          bindString(2, date)
          bindString(3, imageUrl)
        }
    notifyQueries(-1_636_572_153) { emit ->
      emit("Article")
    }
  }

  public fun removeAllArticles() {
    driver.execute(818_246_372, """DELETE FROM Article""", 0)
    notifyQueries(818_246_372) { emit ->
      emit("Article")
    }
  }

  public fun insertSource(
    id: String,
    name: String,
    desc: String,
    language: String,
    country: String,
  ) {
    driver.execute(-232_936_726, """
        |INSERT INTO Source(id, name, desc, language, country)
        |VALUES(?, ?, ?, ?, ?)
        """.trimMargin(), 5) {
          bindString(0, id)
          bindString(1, name)
          bindString(2, desc)
          bindString(3, language)
          bindString(4, country)
        }
    notifyQueries(-232_936_726) { emit ->
      emit("Source")
    }
  }

  public fun removeAllSources() {
    driver.execute(1_369_295_409, """DELETE FROM Source""", 0)
    notifyQueries(1_369_295_409) { emit ->
      emit("Source")
    }
  }
}
