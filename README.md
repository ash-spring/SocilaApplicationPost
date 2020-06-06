# SocilaApplicationPost

Scenarios:

Creation 
A user can get created

Posting
A user can post a 140 character message.

Wall

users can see a list of the messages they've posted, in reverse chronological order.

Following
A user can follow another user. 

Timeline
A user can see a list of the messages posted by all the people they follow, in reverse chronological order.


1) Create User

POST   http://localhost:8080/socialpost/user
	Request	
		{
			
			"userName" : "Ashish"

		}
	Response:
		{
			"userID": 1,
			"userName": "Ashish"
		}


	Request
		{
			
			"userName" : "Amit"
		}
		{
			"userID": 2,
			"userName": "Amit"
		}

	Request
		{
			
			"userName" : "Anoop"
		}
		{
			"userID": 3,
			"userName": "Anoop"
		}



2)  Create Post 

POST  http://localhost:8080/socialpost/wallposts

	Request
		{
			
			"userID" : "1",
			"postMessage" : "This is Ashish First Post"

		}

	Request
		{
			
			"userID" : "1",
			"postMessage" : "This is Ashish Second Post"

		}

	Request
		{
			
			"userID" : "2",
			"postMessage" : "This is Amit First Post"

		}

	Request
		{
			
			"userID" : "2",
			"postMessage" : "This is Amit Second Post"

		}

	Request
		{
			
			"userID" : "3",
			"postMessage" : "This is Anoop First Post"

		}


	Request
		{
			
			"userID" : "3",
			"postMessage" : "This is Anoop Second Post"

		}




3) Get Wall Posts for User by passing User ID (Recent Post first)

GET 	http://localhost:8080/socialpost/wallposts/1

Response:
		[
			{
				"postID": 5,
				"user": {
					"userID": 1,
					"userName": "Ashish"
				},
				"postCreationTime": "2020-06-06T13:29:00.643+00:00",
				"postMessage": "This is Ashish Second Post"
			},
			{
				"postID": 4,
				"user": {
					"userID": 1,
					"userName": "Ashish"
				},
				"postCreationTime": "2020-06-06T13:28:38.924+00:00",
				"postMessage": "This is Ashish First Post"
			}
		]




GET      http://localhost:8080/socialpost/wallposts/2

Response:
		[
			{
				"postID": 7,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:33.675+00:00",
				"postMessage": "This is Amit Second Post"
			},
			{
				"postID": 6,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:21.213+00:00",
				"postMessage": "This is Amit First Post"
			}
		]


GET		http://localhost:8080/socialpost/wallposts/3

Response:

		[
			{
				"postID": 9,
				"user": {
					"userID": 3,
					"userName": "Anoop"
				},
				"postCreationTime": "2020-06-06T13:29:48.666+00:00",
				"postMessage": "This is Anoop Second Post"
			},
			{
				"postID": 8,
				"user": {
					"userID": 3,
					"userName": "Anoop"
				},
				"postCreationTime": "2020-06-06T13:29:44.018+00:00",
				"postMessage": "This is Anoop First Post"
			}
		]



4) Follow User 

		http://localhost:8080/socialpost/follow

	Request
			{
				"userID": 1,
				"followingUserID": 2
			}
	Response
			{
				"followingID": 10,
				"userID": 1,
				"followingUserID": 2
			}


	Request
			{
				"userID": 2,
				"followingUserID": 3
			}
	Response
			{
				"followingID": 11,
				"userID": 2,
				"followingUserID": 3
			}


	Request
			{
				"userID": 3,
				"followingUserID": 1
			}
	Response
			{
				"followingID": 12,
				"userID": 3,
				"followingUserID": 1
			}

	Request
			{
				"userID": 3,
				"followingUserID": 2
			}
	Response
			{
				"followingID": 13,
				"userID": 3,
				"followingUserID": 2
			}




5)  Get TimeLine Posts by User ID based on Followed users (Recent Post first)

GET 	http://localhost:8080/socialpost/timelineposts/1

Response
		[
			{
				"postID": 7,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:33.675+00:00",
				"postMessage": "This is Amit Second Post"
			},
			{
				"postID": 6,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:21.213+00:00",
				"postMessage": "This is Amit First Post"
			}
		]


GET 	http://localhost:8080/socialpost/timelineposts/2

Response
		[
			{
				"postID": 9,
				"user": {
					"userID": 3,
					"userName": "Anoop"
				},
				"postCreationTime": "2020-06-06T13:29:48.666+00:00",
				"postMessage": "This is Anoop Second Post"
			},
			{
				"postID": 8,
				"user": {
					"userID": 3,
					"userName": "Anoop"
				},
				"postCreationTime": "2020-06-06T13:29:44.018+00:00",
				"postMessage": "This is Anoop First Post"
			}
		]
		
		

GET 	http://localhost:8080/socialpost/timelineposts/3

Response
		[
			{
				"postID": 7,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:33.675+00:00",
				"postMessage": "This is Amit Second Post"
			},
			{
				"postID": 6,
				"user": {
					"userID": 2,
					"userName": "Amit"
				},
				"postCreationTime": "2020-06-06T13:29:21.213+00:00",
				"postMessage": "This is Amit First Post"
			},
			{
				"postID": 5,
				"user": {
					"userID": 1,
					"userName": "Ashish"
				},
				"postCreationTime": "2020-06-06T13:29:00.643+00:00",
				"postMessage": "This is Ashish Second Post"
			},
			{
				"postID": 4,
				"user": {
					"userID": 1,
					"userName": "Ashish"
				},
				"postCreationTime": "2020-06-06T13:28:38.924+00:00",
				"postMessage": "This is Ashish First Post"
			}
		]




