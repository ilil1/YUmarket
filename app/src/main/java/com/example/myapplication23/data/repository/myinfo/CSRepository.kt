package com.example.myapplication23.data.repository.myinfo

import com.example.myapplication23.model.customerservicelist.CSModel
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory


/**
 * @주 허희태
 * @부 김건우 정남진 김도엽 배은호
 * @since
 * @throws
 * @description
 */


interface CSRepository {


     fun findCsByCategory(csCategory: CSCategory) : List<CSModel>
}