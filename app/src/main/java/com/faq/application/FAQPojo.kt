package com.faq.application

import android.databinding.BaseObservable
import java.io.Serializable

class FAQPojo(
    var category: String,
    var subFAQs : ArrayList<FAQItem>?
) : BaseObservable(), Serializable
