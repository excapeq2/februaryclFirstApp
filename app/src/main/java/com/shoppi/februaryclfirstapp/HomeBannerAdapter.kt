package com.shoppi.februaryclfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import kotlin.math.roundToInt

class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vp_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val bannerImageView = view.findViewById<ImageView>(R.id.ivid_home_banner_image)
        private val bannerDetailThumbnailImageView = view.findViewById<ImageView>(R.id.ivid_home_banner_mini_image)
        private val bannerDetailArtist = view.findViewById<TextView>(R.id.tvid_home_banner_artist_text)
        private val bannerDetailAlbum = view.findViewById<TextView>(R.id.tvid_home_banner_album_text)

        fun bind(banner: Banner) {
            loadImage(banner.backgroundImageUrl, bannerImageView)
            loadImage(banner.productDetail.thumbnailImageUrl, bannerDetailThumbnailImageView)
            bannerDetailArtist.text = banner.productDetail.brandName
            bannerDetailAlbum.text = banner.productDetail.label

        }




        private fun loadImage(urlString: String, imageView: ImageView){
            GlideApp.with(itemView)
                .load(urlString)
                .into(imageView)
        }



    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}