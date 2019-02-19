package com.faq.application

import android.databinding.BaseObservable
import java.io.Serializable

class FAQItem(
    var faq: String,
    var answer: String
) : BaseObservable(), Serializable
