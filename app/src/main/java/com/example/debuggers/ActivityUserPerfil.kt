package com.example.debuggers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.debuggers.databinding.ActivityUserPerfilBinding
import com.google.firebase.auth.FirebaseAuth

class ActivityUserPerfil : Fragment() {

    private lateinit var binding: ActivityUserPerfilBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mContext : Context

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        binding = ActivityUserPerfilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnCerrarSesion.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(mContext, ActivityLogin::class.java))
            activity?.finishAffinity()
        }
    }
}