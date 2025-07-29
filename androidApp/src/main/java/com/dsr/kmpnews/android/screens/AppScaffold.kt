package com.petros.efthymiou.dailypulse.android

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dsr.kmpnews.android.screens.AboutScreen
import com.dsr.kmpnews.android.screens.ArticleDetailScreen
import com.dsr.kmpnews.android.screens.ArticlesScreen
import com.dsr.kmpnews.android.screens.Screens
import com.dsr.kmpnews.android.screens.SourcesScreen
import com.dsr.kmpnews.articles.application.Article


@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    fun buildDetailRoute(article: Article): String {
        return "${Screens.DETAIL.route}/" +
                Uri.encode(article.title) + "/" +
                Uri.encode(article.desc ?: "") + "/" +
                Uri.encode(article.date) + "/" +
                Uri.encode(article.imageUrl ?: "") + "/"
        ///Uri.encode(article.url)
    }
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                onSourcesButtonClick = { navController.navigate(Screens.SOURCES.route) },
                onArticleClick = { article ->

                })
        }

        composable(Screens.SOURCES.route) {
            SourcesScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }

        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
        composable(
            route = "detail/{url}",
            arguments = listOf(
                navArgument("url") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url") ?: ""
            val url = Uri.decode(encodedUrl) // 🔓 Decode if previously encoded
            ArticleDetailScreen(url = url, onUpButtonClick = { navController.popBackStack() })
        }



    }


}