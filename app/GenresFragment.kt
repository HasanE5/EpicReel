package com.example.epicreel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.epicreel.MovieAdapter
import com.example.epicreel.databinding.FragmentGenresBinding
import com.example.epicreel.Movie

class GenresFragment : Fragment() {

    // تعريف الـ ViewBinding
    private var _binding: FragmentGenresBinding? = null
    private val binding get() = _binding!!

    // قائمة الأفلام المحدثة
    val movies = listOf(
        Movie(1, "Inception", "2h 28m", 4.8),
        Movie(2, "The Dark Knight", "2h 32m", 4.9),
        Movie(3, "Interstellar", "2h 49m", 4.7),
        Movie(4, "Titanic", "3h 15m", 4.6)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // إعداد الـ RecyclerView
        binding.rvMovies.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMovies.adapter = MovieAdapter(movies) { movie ->
            // لما تضغط على الفيلم، يظهر رسالة
            Toast.makeText(
                requireContext(),
                "اخترت: ${movie.title} (${movie.rating}★)",
                Toast.LENGTH_SHORT
            ).show()
        }

        // زر الرجوع
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        // زر الإغلاق
        binding.btnClose.setOnClickListener {
            requireActivity().finish()
        }

        // عنوان الفئة
        binding.tvSciFiMovies.text = "Sci-Fi Movies"
        binding.tvBackToGenres.text = "Back to Genres"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}