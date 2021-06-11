# HackerNewsList - Demo App for Reign
A demo APP for Reign

This is the demo app that I develop. I use MVVM architecture and Retrofit library for consume the API. Unfortunately, I can not develop the data persistence when the app it's offlnae because for time and I have issues with that. For data persistence, I used Room library and i implemented it but i did not finish. I hope you like my solution :)

For develop the app, i use these libraries: 

    Add this for run the kapt pulgin:
    apply plugin: 'kotlin-kapt'

    //LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"

    def activity_version = "1.2.3"

    // Java language implementation
    implementation "androidx.activity:activity:$activity_version"
    // Kotlin
    implementation "androidx.activity:activity-ktx:$activity_version"

    //Swiperefreshlayout
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    //Room
    def room_version = "2.3.0"
    implementation "androidx.room:room-runtime:$room_version"
    kapt  "androidx.room:room-compiler:2.2.5"

    //RecyclerSwipeDecorator
    implementation 'it.xabaras.android:recyclerview-swipedecorator:1.2.3'


    //Retrofit
    implementation 'com.google.code.gson:gson:2.8.6'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
