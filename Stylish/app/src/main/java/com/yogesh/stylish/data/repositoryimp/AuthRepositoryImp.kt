package com.yogesh.stylish.data.repositoryimp

import com.google.firebase.auth.FirebaseAuth
import com.yogesh.stylish.domain.repository.AuthRepository
import com.yogesh.stylish.domain.util.Result
import kotlinx.coroutines.tasks.await


class AuthRepositoryImp(private val firebaseAuth: FirebaseAuth) : AuthRepository {
    override suspend fun login(email: String, password: String): Result<String> {

        return try {

            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.Success("Login Success")

        } catch (e: Exception) {

            Result.Failure(e.localizedMessage ?: "Unexpected error occured during login !")
        }


    }

    override suspend fun signup(email: String, password: String
    ): Result<String> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.Success("Sign up success")
        } catch (e: Exception) {

            Result.Failure("Unknown error during sign up !")

        }


    }


}