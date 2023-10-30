package com.example.onboarding

class OnBoardingAdapter(private val onStartClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.love
        ),
        OnBoard(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.love_and_kind
        ),
        OnBoard(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.raw.heart_love_animation
        ),
        OnBoard(
            "It's Funs and Many more", "",
            R.raw.book_lover
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.apply {
                onBoard.image.let { imgBoard.setAnimation(it) }
                tvTittle.text = onBoard.tittle
                tvDescription.text = onBoard.desc
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
        }
    }

}