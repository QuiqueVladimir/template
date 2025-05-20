package upc.edu.template.presentation.di

import upc.edu.template.data.di.DataModule
import upc.edu.template.presentation.viewmodel.SearchGameViewModel

object PresentationModule {
    fun getSearchGameViewModel(): SearchGameViewModel {
        return SearchGameViewModel(DataModule.getGameRepository())
    }
}