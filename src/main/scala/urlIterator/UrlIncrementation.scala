package urlIterator

class UrlCarIndex(baseUrl: String = "https://www.leboncoin.fr/voitures/offres/?") {

  var state: Int = 0


  def next(): String = {

    val nextURL = s"${baseUrl}o=$state"
    state += 1
    nextURL
  }

}
