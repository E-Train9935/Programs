using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{
    public float speed;
    public Rigidbody camera;

    void Start()
    {
        camera = GetComponent<Rigidbody>();
    }

    void Update()
    {

        camera.velocity = new Vector3(-1*speed, 0, 0);

    }
}
