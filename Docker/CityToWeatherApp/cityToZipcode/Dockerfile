FROM python:3.8-slim

WORKDIR /app

COPY app.py .

EXPOSE 5000

RUN pip install flask

RUN pip install requests

CMD ["python", "app.py"]
