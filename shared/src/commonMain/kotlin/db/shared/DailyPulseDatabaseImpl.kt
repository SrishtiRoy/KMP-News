package petros.efthymiou.dailypulse.db.shared

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass
import petros.efthymiou.dailypulse.db.DailyPulseDatabase
import db.DailyPulseDatabaseQueries

internal val KClass<DailyPulseDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = DailyPulseDatabaseImpl.Schema

internal fun KClass<DailyPulseDatabase>.newInstance(driver: SqlDriver): DailyPulseDatabase =
    DailyPulseDatabaseImpl(driver)

private class DailyPulseDatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), DailyPulseDatabase {
  override val dailyPulseDatabaseQueries: DailyPulseDatabaseQueries =
      DailyPulseDatabaseQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE Article (
          |    title TEXT NOT NULL,
          |    desc TEXT,
          |    date TEXT NOT NULL,
          |    imageUrl TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Source (
          |    id TEXT NOT NULL,
          |    name TEXT NOT NULL,
          |    desc TEXT NOT NULL,
          |    language TEXT NOT NULL,
          |    country TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
