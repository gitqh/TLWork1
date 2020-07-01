package msg

import org.springframework.cloud.contract.spec.Contract


Contract.make {
    name('send message')
    request {
        method 'POST'
        url '/api/send'
        body(
                uid: [anyNumber()],
                msg: anyNonBlankString(),
                startTime: anyNumber(),
                endTime: anyNumber()
        )
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body('''
            {
            "code":200,
            "msg":"success"
            }
        ''')
    }
}