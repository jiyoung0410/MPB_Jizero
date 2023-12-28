package com.example.mpb_week1_1222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mpb_week1_1222.databinding.ActivityFooddetailBinding


class FoodDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFooddetailBinding
    private var originSacc: Int = 500
    private var originProtein: Int = 100
    private var originFat: Int = 200
    private var originkcal: Int = 362


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFooddetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saccSizeTv.text = originSacc.toString() // 초기값 설정
        binding.proteinSizeTv.text = originProtein.toString() // 초기값 설정
        binding.fatSizeTv.text = originFat.toString() // 초기값 설정
        binding.foodKcalNumTv.text = originkcal.toString() // 초기값 설정


        binding.minusTv.setOnClickListener {
            val text = binding.gramTv.text.toString().trim()
            val numericText = text.filter { it.isDigit() }

            if (numericText.isNotEmpty()) {
                var currentValue = numericText.toInt()

                if (currentValue >= 100) {
                    currentValue -= 100
                    binding.saccSizeTv.text = (binding.saccSizeTv.text.toString().toInt() - originSacc).toString() // 변경된 값으로 설정
                    binding.proteinSizeTv.text = (binding.proteinSizeTv.text.toString().toInt() - originProtein).toString() // 변경된 값으로 설정
                    binding.fatSizeTv.text = (binding.fatSizeTv.text.toString().toInt() - originFat).toString() // 변경된 값으로 설정
                    binding.foodKcalNumTv.text = (binding.foodKcalNumTv.text.toString().toInt() - originkcal).toString() // 변경된 값으로 설정
                    binding.gramTv.text = "$currentValue g"
                } else {
                    Toast.makeText(this, "0보다 작을 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "fff보다 작을 수 없습니다.", Toast.LENGTH_SHORT).show()
            }

        }

        binding.plusTv.setOnClickListener {
            val text = binding.gramTv.text.toString().trim()
            val numericText = text.filter { it.isDigit() }


            if (numericText.isNotEmpty()) {
                var currentValue = numericText.toInt()

                currentValue += 100
                binding.saccSizeTv.text = (binding.saccSizeTv.text.toString().toInt() + originSacc).toString() // 변경된 값으로 설정
                binding.proteinSizeTv.text = (binding.proteinSizeTv.text.toString().toInt() + originProtein).toString() // 변경된 값으로 설정
                binding.fatSizeTv.text = (binding.fatSizeTv.text.toString().toInt() + originFat).toString() // 변경된 값으로 설정
                binding.foodKcalNumTv.text = (binding.foodKcalNumTv.text.toString().toInt() + originkcal).toString() // 변경된 값으로 설정
                binding.gramTv.text = "$currentValue g"

            }
        }
    }
}