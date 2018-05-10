package parsers.JSONParser

import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue


case class Attribut(key: String,
                    value: String,
                    key_label: String,
                    value_label: String,
                    generic: Boolean)

trait AttributParser {


  def extractAttributs(jsonObject : JValue):List[Attribut] ={
    implicit val formats = DefaultFormats
    (jsonObject \ "adview"  \ "attributes").extract[List[Attribut]]
  }

  def getValueFromAttribut(attributs:List[Attribut], key:String):String =
    attributs.find(atr => atr.key == key).get.value_label

}
