# Java-chat-application
Project Name: Java Chat Application.
Developer Name: Mayank Kumar

Aim: To communicate between two command Line app using java Socket Programming.

	o	Program can be run on same computer or two different computers.
	o	Both programs will connect with the help of connection oriented protocol, which is called socket programming.
	o	After establishment of connection, we can transfer text messages from one computer to another computer
		or in case of single computer we can transfer the message from one program to another program.

Concept used
	1.	Object Oriented Programming 
	2.	Networking 
	3.	Multithreading


Procedure:
	When we create object of ServerSocket, it sends the request for connection, because Socket programming is connection oriented approach.
	Request will be sent to the server and server will accept the request and it will return the object of Socket.
		    o	Socket Basically provides two types of streams 
			o	First for read the data InputSteram.
			o	Second for send the data OutputStream.

Steps
	i.	Create ServerSocket objectd.
	ii.	Create Socket Object.
	iii.	Send request.
	iv.	Accept request.
	v.	Take InputStream in Client program.
	vi.	Take InputStream in Server program.
	vii.	Starts read and write.

Note:
	o	Both computers must be in same network, if case of two different computer.
	o	In case of single computer use localhost IP (127.0.0.1) for server.
	o	We have to create two programs one for server and second for client.

What we learn through this project.
	o	How ServerSocket is used?
	o	How Socket is used?
	o	How can we connect?
	o	How connection will establish?
	o	How streams are generated?

*********************    Thank You So Much For Reading It  *******************