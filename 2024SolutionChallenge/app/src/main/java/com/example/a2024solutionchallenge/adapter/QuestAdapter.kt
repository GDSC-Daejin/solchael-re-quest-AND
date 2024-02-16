package com.example.a2024solutionchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.a2024solutionchallenge.data.QuestData
import com.example.a2024solutionchallenge.databinding.ItemQuestBinding


class QuestAdapter : RecyclerView.Adapter<QuestAdapter.ItemViewHolder>(){
    private lateinit var binding : ItemQuestBinding
    var itemData = ArrayList<QuestData>()
    private lateinit var context : Context
    private var selectedItem = 0

    inner class ItemViewHolder(private var binding : ItemQuestBinding ) : RecyclerView.ViewHolder(binding.root) {
        private var position: Int? = null
        var questExp = binding.questCompensationTv
        var questContent = binding.questTv
        var questCompleteBtn = binding.questCompleteBtn
        /*var hcUserId = binding.hcUserId*/

        fun bind(itemData: QuestData, position: Int) {
            this.position = position
            questExp.text = itemData.exp.toString()
            questContent.text = itemData.questContent

            binding.questCompleteBtn.setOnClickListener {
                if (itemData.complete == true) {
                    //exp 추가 이벤트
                } else {
                    Toast.makeText(context, "Quest conditions have not been completed.", Toast.LENGTH_SHORT).show()
                }
            }

            /*binding.root.setOnClickListener {
                //자세히 보기 페이지 이동? Todo
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        binding = ItemQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemData[position], position)
    }

    override fun getItemCount(): Int {
        return itemData.size
    }


    interface ItemClickListener {
        fun onClick(view: View, position: Int, itemId: String)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    /*private fun setMultipleSelection(binding: ItemLayoutBinding, s: String?, adapterPosition : Int) {
        if(itemData[adapterPosition].isSelected){
            itemData[adapterPosition].isSelected = false
            changeBackground(binding, adapterPosition)
        }else{
            itemData[adapterPosition].isSelected = true
            changeBackground(binding, adapterPosition)
        }
        Log.e("arrayList", itemData.toString());
        notifyDataSetChanged()
    }

    private fun changeBackground(binding: ItemLayoutBinding, position: Int) {
        if(itemData[position].isSelected){
            val colorStateList = ColorStateList.valueOf(ContextCompat.getColor(context , R.color.purple_200)) //승인
            binding.itemLl.backgroundTintList = colorStateList
        }else{
            val colorStateList = ColorStateList.valueOf(ContextCompat.getColor(context , R.color.black)) //승인
            binding.itemLl.backgroundTintList = colorStateList
        }
    }*/

}