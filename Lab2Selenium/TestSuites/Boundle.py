import unittest


from Morele.Test1 import AddProductTest
from Morele.Test2 import CheckProductTest


tc1 = unittest.TestLoader().loadTestsFromTestCase(AddProductTest)
tc2 = unittest.TestLoader().loadTestsFromTestCase(CheckProductTest)

sanityTestSuite = unittest.TestSuite([tc1, tc2])

unittest.TextTestRunner(verbosity=2).run(sanityTestSuite)
