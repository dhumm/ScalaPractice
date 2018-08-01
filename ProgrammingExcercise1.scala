def isEven(num:Int): Boolean = {
  return num % 2 ==0
}

def hasEven(nums:List[Int]): Boolean = {
  for(num <- nums) {
    if(num % 2 == 0)
      return true
  }
  return false
}

def luckyNumberSlevin(nums:List[Int]): Int = {
  var accumulator:Int = 0
  for(num <- nums) {
    if(num == 7){
      accumulator += 14
    }
    else{
      accumulator += num
    }
  }
  return accumulator
}

def canYouBalance(nums:List[Int]): Boolean = {
  var rightSide:Int = 0
  var leftSide:Int = 0
  for(num <- nums){
    rightSide += num
  }
  for(num <- nums){
    rightSide -= num
    leftSide += num
    if(rightSide == leftSide)
      return true
  }
  return false
}

def isPalindrome(word:String): Boolean = {
  return word.reverse == word
}


println(isPalindrome("tacocat"))
