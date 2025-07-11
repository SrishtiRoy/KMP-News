package petros.efthymiou.dailypulse.db

import kotlin.String

public data class Source(
  public val id: String,
  public val name: String,
  public val desc: String,
  public val language: String,
  public val country: String,
)
