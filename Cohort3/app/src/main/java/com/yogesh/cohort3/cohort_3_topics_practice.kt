package com.yogesh.cohort3

// Collection --> list , set , map , 


fun main() {
    //Immutable list
    /*val immutableList = listOf<Int>(1,2,3,4,5)
    println(immutableList[1])
    println(immutableList.indexOf(5))
    println(immutableList.lastIndexOf(5))
    println(immutableList.contains(4))*/
    
    // Mutable List
    
    val mutableList = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    
    println(mutableList.add(12))
    println(mutableList.removeAt(0))
    println(mutableList.remove(5))
    println(mutableList.contains(9))
    println(mutableList[2])
    println(mutableList)
    
    
    // Maps --> Key Value Pair
    
    val map = mutableMapOf<Int, String>()
    map.put(1,"Yogesh")
    map.put(1,"Verma")
    
    println(map.get(1))
    
    map[1] = "BCA"
    
    
}

