package referentiel

import org.scalatest.{FlatSpec, Matchers}

class JsonSerializerSpec extends FlatSpec with Matchers {

  case class TestClass(int: Int, string: String, double: Double, boolean: Boolean)
  object testClassJsonSerializer extends JsonSerializer[TestClass]

  "serialize a object" should "return a valide json string" in {

    val testClass = TestClass(123, "string", 123143242, true)
    val jsonString = testClassJsonSerializer.serialize(testClass)
    jsonString should include("\"int\":123")
    jsonString should include("\"string\":\"string\"")
    jsonString should include("\"double\":1.23143242E8")
    jsonString should include("\"boolean\":true")
  }


  "deserialize a object" should "return a valide json string" in {
    val expectedResult = TestClass(123, "string", 123143242, true)
    val testJson ="""{"int":123,"string":"string","double":1.23143242E8,"boolean":true}"""
    val parseClass = testClassJsonSerializer.deserialize(testJson)

    parseClass.int should be(123)
    parseClass.string should be("string")
    parseClass.double should be(1.23143242E8)
    parseClass.boolean should be(true)

  }
}
