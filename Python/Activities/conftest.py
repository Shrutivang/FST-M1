import pytest

@pytest.fixture
def numlist():
    #list = {0,1,2,3,4,5,6,7}
    return list(range(11))