package com.alexbur.rentateam.presentation.userslist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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

        viewModel.userListData.observe(viewLifecycleOwner) { users ->
            adapter?.submitList(users)
        }

        viewModel.isLoadingData.observe(viewLifecycleOwner) { isVisible ->
            binding.progressBar.isVisible = isVisible
        }

        viewModel.errorMessageIdData.observe(viewLifecycleOwner) { errorMessageId ->
            Toast.makeText(context, errorMessageId, Toast.LENGTH_SHORT).show()
        }

        viewModel.isRefreshingData.observe(viewLifecycleOwner) { isRefreshing ->
            binding.swipeRefreshLayout.isRefreshing = isRefreshing
        }

        adapter = UsersAdapter(::onUserItemClick)

        binding.usersList.adapter = adapter
        binding.usersList.layoutManager = LinearLayoutManager(context)

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshUsers()
        }
    }

    override fun onDestroyView() {
        adapter = null
        super.onDestroyView()
    }

    private fun onUserItemClick(userEntity: UserEntity) {
        findNavController().navigate(
            R.id.action_usersListFragment_to_detailUserFragment, bundleOf(
                DetailUserFragment.USER_KEY to userEntity
            )
        )
    }
}