package com.alexbur.rentateam.presentation.detailuser

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexbur.rentateam.R
import com.alexbur.rentateam.databinding.FragmentDetailUserBinding
import com.alexbur.rentateam.domain.entity.UserEntity

class DetailUserFragment : Fragment(R.layout.fragment_detail_user) {

    private val binding by viewBinding(FragmentDetailUserBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        private const val USER_KEY = "user_key"

        fun newInstance(user: UserEntity): DetailUserFragment {
            val fragment = DetailUserFragment()
            fragment.arguments = bundleOf(USER_KEY to user)
            return fragment
        }
    }
}