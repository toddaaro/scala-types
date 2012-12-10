
package typestuff

object Utils {

  case class TypeToValue[T, VT](value: VT) {
    def apply() = value
  }

}
