**停车小弟**

Given:有一辆车需要小弟去停，且现在一号停车场还没停满  
When:小弟停车  
Then:取到票，停车成功

Given:有一辆车需要小弟去停，且现在一号停车场停满了，二号库没停满  
When:小弟停车  
Then:取到票，停车成功且停在二号库  

Given:有一辆车需要小弟去停，且现在n-1号停车场停满了，n号库没停满  
When:小弟停车  
Then:取到票，停车成功且停在n号库  

Given:有一辆车需要小弟去取，停在了1号库  
When:给小弟票，小弟取车  
Then:成功取车  

Given:有一辆车需要小弟去取，停在了1号库  
When:不给小弟票  
Then:小弟不取  

**Smart 停车小弟**

Given:有两个空车位一样的停车场，有一辆车  
When:smart小弟去停车  
Then:取到票，停在一号停车场  

Given:一号停车场比第二个停车场空车位多，有一辆车  
When:smart小弟去停车  
Then:取到票，停在一号停车场  

Given:二号停车场比第一个停车场空车位多，有一辆车  
When:smart小弟去停车  
Then:取到票，停在二号停车场  

Given:停车场满了，有一辆车  
When:smart小弟去停车  
Then:停车失败  

Given:有两个停车场，有一辆车停在一号停车场  
When:smart小弟凭票取车  
Then:取车成功  

Given:有两个停车场，有一辆车停在一号停车场  
When:不给小弟票  
Then:小弟不取  