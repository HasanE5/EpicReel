package com.hasan.ahmed.belal.epic_reel

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityRateReviewBinding

class RateReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRateReviewBinding
    private lateinit var starImages: Array<android.widget.ImageView>
    private var currentRating = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRateReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        starImages = arrayOf(
            binding.ivStar1,
            binding.ivStar2,
            binding.ivStar3,
            binding.ivStar4,
            binding.ivStar5
        )

        for (i in starImages.indices) {
            starImages[i].setOnClickListener {
                setRating(i + 1)
            }
        }

        binding.etReview.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val count = s?.length ?: 0
                binding.tvCharCount.text = "$count/500"
                binding.etReview.setSelection(count)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSubmitReview.setOnClickListener {
            if (currentRating == 0) {
                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val reviewText = binding.etReview.text.toString().trim()
            if (reviewText.isEmpty()) {
                Toast.makeText(this, "Please write a review", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Review submitted successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setRating(rating: Int) {
        currentRating = rating
        for (i in starImages.indices) {
            starImages[i].setImageResource(
                if (i < rating) R.drawable.ic_star_full else R.drawable.ic_star_empty
            )
        }
    }
}
