// class Point3D already declared 
fun createPoint(x: Int, y: Int, z: Int): Point3D =
    Point3D().also {
        it.x = x
        it.y = y
        it.z = z
    }