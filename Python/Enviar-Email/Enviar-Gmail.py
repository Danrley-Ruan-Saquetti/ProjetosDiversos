import smtplib
import email.message


def send_email(fromM, password, to, subject, body_email):
    msg = email.message.Message()
    msg['From'] = fromM
    msg['To'] = to
    msg['Subject'] = subject
    msg.add_header('Content-Type', 'text/html')
    msg.set_payload(body_email)

    s = smtplib.SMTP('smtp.gmail.com: 587')
    s.starttls()
    s.login(msg['From'], password)
    s.sendmail(msg['From'], [msg['To']], msg.as_string().encode('utf-8'))
    print('Console: Email enviado!')


if __name__ == '__main__':
    print('Console: Por motivos de segurança, nenhuma informação do usuário será compartilhada ou salva!\n')
    fromM = f"""{str(input('-> Informe o remetendo do email: '))}"""
    password = f"""{str(input('-> Informe a senha de login do remetente do email: '))}"""
    to = f"""{str(input('-> Informe o destinatário do email: '))}"""
    subject = f"""{str(input('-> Informe o assunto do email: '))}"""
    body_email = f"""{str(input('-> Informe o corpo do email: '))}"""

    if int(input('-> Deseja enviar o email? 1 - Sim: ')) == 1:
        send_email(fromM, password, to, subject, body_email)
    else:
        print('Console: Email não enviado!')
