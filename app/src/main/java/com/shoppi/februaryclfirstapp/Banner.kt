package com.shoppi.februaryclfirstapp

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    @SerializedName("product_detail") val productDetail: ProductDetail
)



data class ProductDetail(
    @SerializedName("brand_name") val brandName: String,
    val label: String,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String,
    @SerializedName("product_id") val productId: String
)