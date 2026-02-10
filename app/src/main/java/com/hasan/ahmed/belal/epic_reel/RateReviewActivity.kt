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

        // تهيئة نجوم التقييم
        starImages = arrayOf(
            binding.ivStar1,
            binding.ivStar2,
            binding.ivStar3,
            binding.ivStar4,
            binding.ivStar5
        )

        // إعداد النجوم
        for (i in starImages.indices) {
            starImages[i].setOnClickListener {
                setRating(i + 1)
            }
        }

        // إعداد مُعدّل النص
        binding.etReview.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val count = s?.length ?: 0
                binding.tvCharCount.text = "$count/500"

                // الحل الصحيح: استخدام count بدلًا من s.length
                binding.etReview.setSelection(count)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // زر الإغلاق
        binding.btnClose.setOnClickListener {
            finish()
        }

        // زر الإرسال
        binding.btnSubmitReview.setOnClickListener {
            // تحقق من وجود تقييم
            if (currentRating == 0) {
                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // تحقق من وجود مراجعة
            val reviewText = binding.etReview.text.toString().trim()
            if (reviewText.isEmpty()) {
                Toast.makeText(this, "Please write a review", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // إرسال المراجعة (سيتم تنفيذه لاحقًا)
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