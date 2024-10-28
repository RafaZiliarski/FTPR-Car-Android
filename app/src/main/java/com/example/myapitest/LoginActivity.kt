package com.example.myapitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapitest.databinding.ActivityLoginBinding
import com.example.myapitest.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInCLient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSigInLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGoogleLogin()
        setupView()
        verifyLoggedUser()
    }

    private fun setupView() {

    }

    private fun verifyLoggedUser() {
        if (auth.currentUser != null) {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    private fun setupGoogleLogin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("521132139537-ajkqunk0suknk57g0rh40hhppk65vu6f.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInCLient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()
        googleSigInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                account.idToken?.let { idToken ->
                    firebaseAuthWithGoogle(idToken)
                }
            } catch (e: ApiException) {
                Log.e("LoginActivity", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                onCredentialCompleteListener(task, idToken)
            }
    }

    private fun onCredentialCompleteListener(
        task: Task<AuthResult>,
        loginType: String
    ) {
        if (task.isSuccessful) {
            val user = auth.currentUser
            Log.d("LoginActivity", "Login Type: ${loginType}, User: $user")
            navigateToMainActivity()
        } else {
            showToast("Erro com o login usnado o ${loginType}",
                Toast.LENGTH_LONG
            )
        }
    }

    private fun signIn() {
        googleSigInLauncher.launch(googleSignInCLient.signInIntent)
    }

    private fun showToast(mensagem: String, duracao: Int) {
        if (duracao == Toast.LENGTH_SHORT) {
            Toast.makeText(
                this,
                mensagem,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                this,
                mensagem,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)

    }
}