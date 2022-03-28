package com.alexbur.rentateam.presentation.aboutcompany

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexbur.rentateam.R
import com.alexbur.rentateam.databinding.FragmentAboutCompanyBinding

class AboutCompanyFragment : Fragment(R.layout.fragment_about_company) {

    private val binding by viewBinding(FragmentAboutCompanyBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance(): AboutCompanyFragment {
            return AboutCompanyFragment()
        }
    }
}