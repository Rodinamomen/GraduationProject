package com.example.graduationproject.network

import android.net.Uri
import android.util.Log
import com.example.graduationproject.company.model.CompanyData
import com.example.graduationproject.company.model.CompanyTranscription
import com.example.graduationproject.company.model.CompanyTranscriptionWithAudio
import com.example.graduationproject.home.model.TranscriptionResponse
import okhttp3.OkHttpClient
import java.net.URI
import java.net.URL

object Client:RemoteDataSource {

    override suspend fun getTranscription(url: Uri?): TranscriptionResponse {
        return Helper.retrofit.create(Service::class.java).getTranscription(url)
    }

    override suspend fun getCompanyWithAudio(url: Uri?): CompanyTranscriptionWithAudio {
        return Helper.retrofit.create(Service::class.java).getCompanyWithAudio(url)
    }

    override suspend fun getCompanyWithText(companyName: String): CompanyTranscription {

        return Helper.retrofit.create(Service::class.java).getCompanyWithText(companyName)
    }

    override suspend fun getListOfCompanies(): List<CompanyData> {
        return Helper.retrofit.create(Service::class.java).getListOfCompanies()
    }

}