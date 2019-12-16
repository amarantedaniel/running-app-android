package com.tigerhood.running

interface HomeContract {
    interface View {

    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {

    }

    interface InteractorOutput {

    }
}