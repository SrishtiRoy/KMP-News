package petros.efthymiou.dailypulse.db

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import db.DailyPulseDatabaseQueries
import kotlin.Unit
import petros.efthymiou.dailypulse.db.shared.newInstance
import petros.efthymiou.dailypulse.db.shared.schema

public interface DailyPulseDatabase : Transacter {
  public val dailyPulseDatabaseQueries: DailyPulseDatabaseQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = DailyPulseDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): DailyPulseDatabase =
        DailyPulseDatabase::class.newInstance(driver)
  }
}
