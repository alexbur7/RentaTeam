package com.alexbur.rentateam.presentation.userslist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexbur.rentateam.R
import com.alexbur.rentateam.appComponent
import com.alexbur.rentateam.databinding.FragmentUsersListBinding
import com.alexbur.rentateam.domain.entity.UserEntity
import com.alexbur.rentateam.presentation.detailuser.DetailUserFragment
import com.alexbur.rentateam.presentation.userslist.adapter.UsersAdapter
import com.alexbur.rentateam.presentation.utils.ViewModelFactory
import javax.inject.Inject

class UsersListFragment : Fragment(R.layout.fragment_users_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentUsersListBinding::bind)
    private val viewModel by viewModels<UsersListViewModel> { viewModelFactory }
    private var adapter: UsersAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UsersAdapter(::onUserItemClick)
    }

    override fun onDestroyView() {
        adapter = null
        super.onDestroyView()
    }

    private fun onUserItemClick(userEntity: UserEntity) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DetailUserFragment.newInstance(userEntity))
            .addToBackStack(USER_LIST_NAME)
            .commit()
    }

    companion object {
        private const val USER_LIST_NAME = "user_list_name"

        fun newInstance(): UsersListFragment {
            return UsersListFragment()
        }
    }
}