console.log('-------------------------------------------------------------------------------------------------------')
import { SocketApplication } from './app/socket'
import { app } from './app'

app.build(SocketApplication)
app.listen(3000)