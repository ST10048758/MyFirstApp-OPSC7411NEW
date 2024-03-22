package com.example.myfirstapp_opsc7411

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

fun openIntent(activity: Activity, order: String, activityToOpen: Class<*>){

    //declare intenet with context and class to pass the value
    val intent = Intent(activity, activityToOpen)

    //pass through the string value with the key "order"
    intent.putExtra("Order", order)

    //Start activity
    activity.startActivity(intent)
}

fun shareIntent(context: Context, order: String){

    //Create new intent object fr sending data
    var sendIntent = Intent()


    // Sets the action of the intent to the ACTION_SEND, indicating that the intent is
    sendIntent.setAction(Intent.ACTION_SEND)

    sendIntent.putExtra(Intent.EXTRA_TEXT, order)

    sendIntent.setType(("text/plain"))

    var shareIntent = Intent.createChooser(sendIntent, null)

    context.startActivity(shareIntent)
}

fun shareIntent(context: Context, order: Order){
    var sendIntent = Intent()

    sendIntent.setAction(Intent.ACTION_SEND)

    var shareOrderDetails = Bundle()
    shareOrderDetails.putString("productname", order.productName)
    shareOrderDetails.putString("customerName", order.customerName)
    shareOrderDetails.putString("customerCell", order.customerCell)

    sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)

    sendIntent.setType("text/plain")

    var shareIntent = Intent.createChooser(sendIntent, null)
    context.startActivity(shareIntent)
}